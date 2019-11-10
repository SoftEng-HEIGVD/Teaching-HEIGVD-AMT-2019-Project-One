from random import randint

f= open("players.csv","w+")

for i in range(1,249000):
     f.write("%d,\"Player%d\", \"Name%d\", %d \n" % (i,i ,i ,(i/5)+6))




matchf = open("matches.csv", "w+")

matchesPlayer= open("matchesPlayer.csv", "w+")
for i in range(1,150000):
     team1=randint(1,50000)
     team2=randint(1,50000)
     if team1==team2:
          team2= ((team1+1)%50000)+1
     winner= randint(1,2)
     scoreLoser= randint(0,14)
     if winner==1:
          team1score=15
          team2score=scoreLoser
     else:
          team1score = scoreLoser
          team2score = 15

     for j in range(5):
          matchesPlayer.write("%d, %d, %d\n" %(i, 1, (team1-1)*5+j ))
     for j in range(5):
          matchesPlayer.write("%d, %d, %d\n" % (i, 2, (team2 - 1) * 5 + j))
     matchf.write("%d,%d, %d, %d, %d\n" % (i,team1score,team2score,team1,team2))


