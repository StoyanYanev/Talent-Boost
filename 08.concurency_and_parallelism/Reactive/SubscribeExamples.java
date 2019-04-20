package Reactive;

import reactor.core.publisher.Flux;

public class SubscribeExamples {
    private static final String SEPARATOR = "==========================================";
    private static final Flux<String> flux = Flux.just("foo", "bar", "foobar");

    public static void subscribeFlux() {
        flux.subscribe();
        flux.map(i -> {
            System.out.print(i + " ");
            return i;
        }).subscribe();
        System.out.println();
    }

    public static void subscribeWithError() {
        Flux.range(1, 4)
                .map(i -> {
                    if (i < 4) {
                        return i;
                    } else {
                        throw new RuntimeException("Got to 4");
                    }
                })
                .subscribe(System.out::println, e -> System.out.println(e.getMessage()));
    }

    public static void main(String[] args) {
        System.out.println(SEPARATOR);
        subscribeFlux();
        System.out.println(SEPARATOR);
        subscribeWithError();
        System.out.println(SEPARATOR);
    }
}