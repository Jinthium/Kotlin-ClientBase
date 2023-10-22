package me.jinthium.logger

object GlobalLogger {
    val logs = LinkedHashMap<String, LogType>()

    fun appendLog(message: String, type: LogType) {
        logs[message] = type
    }

    fun printStart() {
        for((logMessage, logType) in logs){
            println("${logType.name}: $logMessage")
        }
    }
}

enum class LogType {
    WARNING,
    INFO
}