import pandas as pd

board = []

first_line = [" " if i % 2 == 0 else "_" for i in range(7)]
last_line = [" " if i % 2 == 0 else "_" for i in range(7)]

board.append(first_line)

for i in range(3):
    row = ["|" if i % 2 == 0 else " " for i in range(7)]
    line = [" " if i % 2 == 0 else "_" for i in range(7)]
    board.append(row)
    board.append(line)



df = pd.DataFrame(board)

mark_down = df.to_markdown()

with open("markdown.txt", "w") as f:
    f.write(mark_down)

