import groovy.cli.picocli.CliBuilder
import groovy.xml.XmlSlurper

def cli = new CliBuilder(usage: 'blah')
//cli._(longOpt:'url', args:1, argName:'FTP', 'Set the FTP resource to work with')
//def options = cli.parse(args)

def ftpUrl = "ftp://localhost:2021/IDQ11295.xml"

def forecastData = new XmlSlurper().parse(ftpUrl)


forecastData.forecast.area.findAll { node ->
    node.@type == "location"
}.each { area ->

    def latestForecast = area['forecast-period'].find { node ->
        node.@index == "0"
    }

    def maxTemp = latestForecast.element.find { node ->
        node.@type == "air_temperature_maximum"
    }.text()

    def minTemp = latestForecast.element.find { node ->
        node.@type == "air_temperature_minimum"
    }.text()

    def precis = latestForecast.text.find { node ->
        node.@type == "precis"
    }.text()

    println "${area.@description}: $precis - $minTemp to $maxTemp"
    //println latestForecast.element
}
