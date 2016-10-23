package maxmoto1702.clock.console.renderers

import maxmoto1702.clock.console.symbols.*
import maxmoto1702.clock.console.utils.ConsoleOutput

class ConsoleRenderer implements Renderer {
    final static COLUMNS = 128
    final static LINES = 36

    @Override
    def render(time) {
        def hour = time.get(Calendar.HOUR)
        def minute = time.get(Calendar.MINUTE)
        def output = new ConsoleOutput()
        if (hour < 10) {
            output.add(getSymbol('0'))
        } else {
            output.add(getSymbol(hour.intdiv(10)))
        }
        output.addSeparate()
        output.add(getSymbol(hour % 10))
        output.addSeparate()
        output.add(getSymbol(':'))
        output.addSeparate()
        if (minute < 10) {
            output.add(getSymbol('0'))
        } else {
            output.add(getSymbol(minute.intdiv(10)))
        }
        output.addSeparate()
        output.add(getSymbol(minute % 10))
        def dy = LINES - output.outputLines.size()
        (0..dy / 2).each { println() }
        output.outputLines.eachWithIndex { line, idx ->
            def dx = COLUMNS - (line as String).length()
            (1..dx / 2).each { print ' ' }
            println(line)
        }
        (0..dy - dy / 2).each { println() }
    }

    private Symbol getSymbol(value) {
        switch (value) {
            case '0':
            case 0:
                return new Zero()
            case '1':
            case 1:
                return new One()
            case '2':
            case 2:
                return new Two()
            case '3':
            case 3:
                return new Three()
            case '4':
            case 4:
                return new Four()
            case '5':
            case 5:
                return new Five()
            case '6':
            case 6:
                return new Six()
            case '7':
            case 7:
                return new Seven()
            case '8':
            case 8:
                return new Eight()
            case '9':
            case 9:
                return new Nine()
            case ':':
                return new Colon()
            default:
                return null
        }
    }
}
