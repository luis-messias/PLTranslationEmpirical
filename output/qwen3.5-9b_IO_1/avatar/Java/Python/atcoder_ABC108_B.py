def revpos(p, q):
    vec = [p[0] - q[0], p[1] - q[1]]
    tmp = vec[0]
    vec[0] = vec[1]
    vec[1] = -tmp
    newpos = [q[0] + vec[0], q[1] + vec[1]]
    return newpos

input_list = list(map(int, input().split()))
position = [[input_list[0], input_list[1]], [input_list[2], input_list[3]]]
position[2] = revpos(position[0], position[1])
position[3] = revpos(position[1], position[2])
if position[0] == revpos(position[2], position[3]):
    print("OK")
output = [position[2][0], position[2][1], position[3][0], position[3][1]]
for i in output:
    print(i)
