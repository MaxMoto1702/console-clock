package maxmoto1702.clock.console.utils

class ConsoleOutput {
    def outputLines = []

    def add(symbol) {
        (symbol.get() as List).eachWithIndex { line, idx ->
            if (!outputLines[idx]) {
                outputLines += ""
            }
            outputLines[idx] += line
        }
    }

    def addSeparate() {
        outputLines = outputLines.collect {
            it += '    '
        }
    }
}
