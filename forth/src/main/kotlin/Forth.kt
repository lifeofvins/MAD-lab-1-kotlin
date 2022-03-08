class Forth {
    val stack: MutableList<Int> = mutableListOf()

    fun evaluate(vararg line: String): List<Int> {
        var inputcmds: List<String>
        var output: List<Int> = listOf()

        val operators: List<String> = listOf("+", "-", "*", "/")
        val commands: List<String> = listOf("DUP", "DROP", "SWAP", "OVER")
        val definitions: MutableList<String> = mutableListOf()

        if (line.size == 0)
            return emptyList()
        if (line[0] == " ")
            return emptyList()
        for ((index, cmd) in line.withIndex()) {
            inputcmds = cmd.split(" ")
            if (inputcmds[0] == ":" && inputcmds[inputcmds.size - 1] == ";") {
                // definition mode
                definitions.add(inputcmds[1])

            } else if() {
                //
            }

        }

        return output
    }

}
