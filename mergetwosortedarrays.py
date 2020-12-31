'''
This code is the merge sort part. It demonstrates the merging algo for two sorted arrays. 

Example input is
1,3,3,4,5,8,9
2,3,6,7,10
'''
line1 = list(map(int, input().split(","))) # This is one way to split the string with , delimiter and make a list
line2 = list(map(int, input().split(","))) 
# line1 = [int(item) for item in input().split(",")] # This is another way to split the string with , delimiter and make a list
# line2 = [int(item) for item in input().split(",")] 

answer = [None]*(len(line1)+len(line2))

i=0
j=0
k=0
# print(input() + "$$$$$")
while (i < len(line1) and j < len(line2)): 
    if (line1[i] < line2[j]): 
        answer[k] = line1[i]
        k += 1
        i += 1
    elif (line1[i] > line2[j]):
        answer[k] = line2[j]
        k += 1
        j += 1
    else:
        answer[k] = line1[i]
        k += 1
        i += 1    
    
    # if (input() == ""): # To debug by stopping the loop. When you hit ENTER, the string is nothing and hence we compare it to ""
    #     print(answer)
    #     continue

while (i < len(line1)): 
    answer[k] = line1[i]
    k += 1
    i += 1

while (j < len(line2)):
    answer[k] = line2[j]
    k += 1
    j += 1

print(answer)
