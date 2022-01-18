class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        for i in range (9):
            for j in range (9):
                if (board[i][j] != '.'):
                    if(not self.valid(board, i, j)):
                        return False
        return True


    def valid(self, board, i, j):
        currValue = board[i][j]
        for a in range(9):
            if (a != i and board[a][j] == currValue):
                return False
    
        for b in range (9):
            if (b != j and board[i][b] == currValue):
                return False

        startRow = (int(i / 3) * 3)
        endRow = startRow + 3
        startCol = (int(j / 3) * 3)
        endCol = startCol + 3
        for c in range(startRow, endRow):
            for d in range(startCol, endCol):
                if (c != i and d != j and board[c][d] == currValue):
                    return False
        return True

    def fasterMethod(self, board):
        rows = []
        columns = []
        boxes = []

        for temp in range(9):
            rows.append[]


if __name__ == "__main__":

    data =  [["5","3",".",".","7",".",".",".","."]
            ,["6",".",".","1","9","5",".",".","."]
            ,[".","9","8",".",".",".",".","6","."]
            ,["8",".",".",".","6",".",".",".","3"]
            ,["4",".",".","8",".","3",".",".","1"]
            ,["7",".",".",".","2",".",".",".","6"]
            ,[".","6",".",".",".",".","2","8","."]
            ,[".",".",".","4","1","9",".",".","5"]
            ,[".",".",".",".","8",".",".","7","9"]]
    
    answer = Solution()
    print(answer.isValidSudoku(data))