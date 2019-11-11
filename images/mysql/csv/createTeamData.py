from random import randint

f= open("teams.csv","w+")

for i in range(1,50001):
	f.write("%d,\"Team%d\", 1\n" % (i,i))