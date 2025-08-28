import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class MicrosoftInterviewQuestion {

    // Application:
    //Domain

    //Infra:
    //Application
    // Domain

    //UI:
    //Infra
    //Application

    public static void main(String[] args) {

        ProjectSet application = new ProjectSet("application");
        ProjectSet domain = new ProjectSet("domain");
        ProjectSet common = new ProjectSet("common");
        application.dependencies.add(domain);
        application.dependencies.add(common);

        ProjectSet infra = new ProjectSet("Infra");
        infra.dependencies.add(application);
        infra.dependencies.add(domain);

        ProjectSet ui = new ProjectSet("UI");
        ui.dependencies.add(infra);
        ui.dependencies.add(application);

//        ui.build(new HashSet<>());

        ExecutorService executor = Executors.newFixedThreadPool(8);

        // Kick off the build
        ui.buildAsync(new ConcurrentHashMap<>(), executor).join();

        executor.shutdown();

    }


}


class ProjectSet {

    List<ProjectSet> dependencies;

    private String name;

    public ProjectSet(String name) {
        this.name = name;
        this.dependencies = new ArrayList<>();
    }

    public CompletableFuture<Void> buildAsync(Map<ProjectSet, CompletableFuture<Void>> cache,
                                              ExecutorService executor) {
        // check if already cached
        CompletableFuture<Void> existing = cache.get(this);
        if (existing != null) return existing;

        // create a placeholder future and put it in cache immediately
        CompletableFuture<Void> placeholder = new CompletableFuture<>();
        cache.put(this, placeholder);

        // Build dependencies first
        List<CompletableFuture<Void>> depFutures = dependencies.stream()
                .map(dep -> dep.buildAsync(cache, executor))
                .collect(Collectors.toList());

        // Once dependencies complete, run the build task
        CompletableFuture<Void> buildFuture = CompletableFuture
                .allOf(depFutures.toArray(new CompletableFuture[0]))
                .thenRunAsync(() -> {
                    System.out.println("Build done for project " + name + " by " +
                            Thread.currentThread().getName());
                    try {
                        Thread.sleep(500); // simulate build time
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }, executor);

        // complete the placeholder with the actual buildFuture
        buildFuture.whenComplete((res, ex) -> {
            if (ex == null) {
                placeholder.complete(res);
            } else {
                placeholder.completeExceptionally(ex);
            }
        });

        return placeholder;
    }

    public void build(Set<ProjectSet> buildSet) {
        if (dependencies != null && !dependencies.isEmpty()) {
            for (ProjectSet dependency : dependencies) {
                if (!buildSet.contains(dependency)) {
                    dependency.build(buildSet);
                    buildSet.add(dependency);
                }
            }
        }

        if (!buildSet.contains(this)) {
            System.out.println("Build done for project " + name);
            buildSet.add(this);
        }
    }
}


class Project {

    List<Project> dependencies;

    private String name;

    private boolean isCompiled;

    public boolean canCompile() {
        return !isCompiled;
    }

    public Project(String name) {
        this.name = name;
        this.dependencies = new ArrayList<>();
    }

    public CompletableFuture<Void> buildAsync(Map<Project, CompletableFuture<Void>> cache,
                                              ExecutorService executor) {
        // reuse already-scheduled build if exists
        CompletableFuture<Void> existing = cache.get(this);
        if (existing != null) return existing;

        // placeholder so recursion doesn’t re-schedule
        CompletableFuture<Void> placeholder = new CompletableFuture<>();
        cache.put(this, placeholder);

        // schedule dependencies first
        List<CompletableFuture<Void>> depFutures = dependencies.stream()
                .map(dep -> dep.buildAsync(cache, executor))
                .collect(Collectors.toList());

        // when dependencies complete, compile this project
        CompletableFuture<Void> buildFuture = CompletableFuture
                .allOf(depFutures.toArray(new CompletableFuture[0]))
                .thenRunAsync(() -> {
                    if (canCompile()) {
                        System.out.println("Build done for project " + name +
                                " by " + Thread.currentThread().getName());
                        isCompiled = true;
                    }
                }, executor);

        // complete placeholder with real future
        buildFuture.whenComplete((res, ex) -> {
            if (ex == null) placeholder.complete(res);
            else placeholder.completeExceptionally(ex);
        });

        return placeholder;
    }

    public void build() {
        if (dependencies != null && !dependencies.isEmpty()) {
            for (Project dependency : dependencies) {
                if (dependency.canCompile()) {
                    dependency.build();
                }
            }
        }
        if (canCompile()) {
            System.out.println("Build done for project " + this.name);
        }
        this.isCompiled = true;
    }
}