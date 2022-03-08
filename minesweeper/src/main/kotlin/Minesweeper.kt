data class MinesweeperBoard(val inputBoard: List<String>) {

    // TODO: Implement proper constructor

    fun withNumbers(): List<String> {
        var counterEntry: Int = 0
        var output: MutableList<String> = mutableListOf()
        var stringRow: String = ""
        /**
         * Square analysis:
         * 0 1 2
         * 3 4 5
         * 6 7 8
         *
         * (-1,-1) (-1,+0) (-1,+1)
         * (+0,-1) (+0,+0) (+0,+1)
         * (+1,-1) (+1,+0) (+1,+1)
         */
        for ((i, row) in this.inputBoard.withIndex()) {
            for ((j, value) in row.withIndex()) {
                if (value == ' ') {
                    // x and y are the coordinates of the aiming element in the table
                    for (x in -1..1) {
                        for (y in -1..1) {
                            if ((i + x) >= 0 && (i + x) <= this.inputBoard.size - 1
                                    && (j + y) >= 0 && (j + y) <= row.length - 1) {
                                // Do the check
                                if (this.inputBoard[i + x][j + y] == '*') {
                                    counterEntry++
                                }
                            }
                        }
                    }
                } else {
                    counterEntry = -1
                }
                if (counterEntry == -1)
                    stringRow += "*"
                else if (counterEntry == 0)
                    stringRow += " "
                else
                    stringRow += counterEntry
                // Reset of the counter
                counterEntry = 0;
            }
            output.add(i, stringRow)
            stringRow = ""
        }

        return output
    }
}
