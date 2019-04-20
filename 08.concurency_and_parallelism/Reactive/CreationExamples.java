package Reactive;

import reactor.core.publisher.Flux;

public class CreationExamples {
    private static final String SEPARATOR = "==========================================";

    private static void createFlux() {
        Flux<String> flux = Flux.just("foo", "bar", "foobar");
        subscribeAndPrint(flux);
    }

    private static void createFluxWithRange() {
        Flux<Integer> flux = Flux.range(1, 4);
        subscribeAndPrint(flux);
    }

    private static void subscribeAndPrint(Flux<?> flux) {
       flux.subscribe(System.out::println);
    }

    public static void main(String[] args) {
        System.out.println(SEPARATOR);
        createFlux();
        System.out.println(SEPARATOR);
        createFluxWithRange();
        System.out.println(SEPARATOR);
    }
}