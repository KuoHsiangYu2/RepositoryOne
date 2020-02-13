#include <cstdlib>
#include <ctime>
#include <iostream>
#include <string>

using namespace std;

static bool breakFlag = false;

class Warrior {
private:
	string name = "";//姓名
	int health = 0;//生命值
	int attack = 0;//攻擊力
	int heal = 0;//治癒力

public:
	Warrior(string name) {
		//constructor 戰士生成時完成的事
		this->name = name;
		health = 100;//生命值
		attack = 20;//攻擊力
		heal = 10;//治癒力
	}

	int doAttack() {
		//戰士可以發動攻擊
		//(1)攻擊對手
		cout << name << " 發動攻擊，" << name << " 生命值：" << health << endl;
		return attack;
	}

	void beAttacked(int attackValue) {
		//戰士可以被攻擊
		//(1)對手被攻擊
		health = health - attackValue;
		if (health > 0) {
			cout << name << " 受到 " << attackValue << " 點傷害，生命值：" << health << endl;
		}
		else {
			cout << name << " 受到 " << attackValue << " 點傷害，生命值：" << health <<
				"，" << name << "勇者 陣亡。" << endl;
			breakFlag = true;
		}
	}

	void doHeal() {
		//戰士可以發動治療
		//(2)回復生命
		health = health + heal;
		cout << name << " 使用補血技能（補血量）：" << heal << "，生命值：" << health << endl;
	}

	void addAttack() {
		//戰士可以增加攻擊力
		//(3)劍舞
		/* 固定亂數種子 */
		srand((unsigned int)time(NULL));
		int random = 0;
		//random = (rand() % (15 - 5 + 1)) + 5;// 5 ~ 15
		random = (rand() % 11) + 5;// 5 ~ 15
		attack = attack + random;
		cout << name << "：劍舞！提升 " << random << " 點攻擊力（5 ~ 15）" << endl;
		cout << "目前攻擊力：" << attack << " 點，生命值：" << health << endl;
	}

	string getName() {
		//可以回傳戰士的姓名
		return name;
	}

	int getHealth() {
		//可以回傳戰士的生命值
		return health;
	}

	int getAttack() {
		//可以回傳戰士的攻擊力
		return attack;
	}

	int getHeal() {
		//可以回傳戰士的治癒力
		return heal;
	}
};

void takeAction(int select, Warrior userWarrior, Warrior enemyWarrior) {
	//執行選項1, 2, 3其中一項操作。
	int attackValue = 0;
	switch (select) {
	case 1:
		attackValue = userWarrior.doAttack();
		enemyWarrior.beAttacked(attackValue);
		break;
	case 2:
		userWarrior.doHeal();
		break;
	case 3:
		userWarrior.addAttack();
		break;
	default:
		printf("error. 請輸入 1 ~ 3 之間的數字。\n");
		break;
	}
}

void checkWinner(Warrior warriorA, Warrior warriorB) {
	//檢查誰的生命值歸0、找出贏家。
	if (warriorA.getHealth() <= 0) {
		cout << warriorB.getName() << " 獲勝！" << endl;
	}
	if (warriorB.getHealth() <= 0) {
		cout << warriorA.getName() << " 獲勝！" << endl;
	}
}

int main(int argc, char *argv[]) {
	system("color f0");

	/*  */

	string userName = "";
	string enemyName = "Monster";

	cout << "勇者大亂鬥，請輸入勇者的名字：";
	cin >> userName;

	Warrior userWarrior(userName);
	Warrior enemyWarrior(enemyName);

	cout << "勇者" << userWarrior.getName() << " 華麗登場" << endl;
	cout << "生命值：" << userWarrior.getHealth() << " 攻擊力：" <<
		userWarrior.getAttack() << " 治癒力：" << userWarrior.getHeal() << endl << endl;

	cout << "你的對手 " << enemyWarrior.getName() << "勇者" << " 華麗登場" << endl;
	cout << "生命值：" << enemyWarrior.getHealth() << " 攻擊力：" <<
		enemyWarrior.getAttack() << " 治癒力：" << enemyWarrior.getHeal() << endl << endl;

	cout << "開始戰鬥" << endl << endl;

	int count = 1;
	int userInput = 0;
	int enemyInput = 0;
	breakFlag = false;
	while (false == breakFlag) {
		cout << "/******** Round" << count << " ********/" << endl;

		cout << "選擇 (1)攻擊對手 (2)回復生命 (3)劍舞" << endl;
		cin >> userInput;
		takeAction(userInput, userWarrior, enemyWarrior);
		checkWinner(userWarrior, enemyWarrior);

		if (true == breakFlag) {
			break;
		}

		cout << endl;
		cout << "對手的回合" << endl;
		srand((unsigned int)time(NULL));
		//enemyInput = (rand() % (3 - 1 + 1)) + 1;// 1 ~ 3
		enemyInput = (rand() % 3) + 1;// 1 ~ 3
		takeAction(enemyInput, enemyWarrior, userWarrior);
		checkWinner(userWarrior, enemyWarrior);

		if (true == breakFlag) {
			break;
		}

		cout << "************************" << endl << endl;

		count = count + 1;
	}

	cout << endl;
	system("pause");
	return 0;
}
