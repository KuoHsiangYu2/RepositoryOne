#coding=utf-8
#testLoop59.py
#python 3.7.2

#參考 蘇彥儒 的寫法，重新改寫 input 的提示字句。

sum = 0.0
avg = 0.0
i = 1
while(i <= 5):
    score = float(input(f"{i}. please input 100 to 200: "))
    if not(100 <= score and score <= 200):
        print("once again")
        continue
    sum = sum + score
    i = i + 1
    
avg = sum / 20.0
print("avg is: %.2f"%(avg))

'''
https://www.facebook.com/groups/pythontw/permalink/10159736360778438/
https://www.facebook.com/groups/pythontw/permalink/10159736360778438/?comment_id=10159736490823438
All Feed
49 分鐘
不好意思，老是拋出問題，
然後這應該是小問題..
但是我不知道卡在哪裡
我有一個迴圈，我要輸入20次，資料介於100到200之間
若輸入的整數大於200或小於100則扣除這一次後再繼續跑。
可是我發現，例如我第一次輸入錯誤，
所以原本i=1 變成i=0
回到for迴圈後又變成i=2開始跑，並不是0+1為1的方式。
想請各位協助我，應該是有個細節我沒注意到..
麻煩了，謝謝!
sum=0
for i in range(1,20):
score=float(input("please input 100 to 200"))
if not(100<=score<=200):
print("once again")
i-=1
continue
sum+=score
avg=sum/20
print("avg is: %.2f"%avg)
'''
