package maxmoto1702.clock.console

import maxmoto1702.clock.console.renderers.ConsoleRenderer

class Application {
    static void main(String... args) {
        sleep(System.currentTimeMillis() % 60_000)
        def renderer = new ConsoleRenderer()
        while (true) {
            renderer.render(Calendar.getInstance())
//            sleep(1000)
            sleep(60 * 1000)
        }
    }
}
