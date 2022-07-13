class User:
    def __init__(self,name,age,account_balance):
        self.name = "name"
        self.age = age
        self.account_balance = account_balance

    def display_user_balance(self):
        print(self.account_balance)
        return self

    def make_deposit(self,amount):
        self.account_balance += amount
        return self

    def make_withdrawl(self,amount):
        self.account_balance -= amount
        return self
    
    def make_transfer(self,amount,other_user):
        self.account_balance -= amount
        other_user.account_balance += amount
        return self


John = User("John",50,1500)
Sarah = User("Sarah",23,500)
Josh = User("Josh",32, 2300)

John.make_deposit(200).make_deposit(200).make_deposit(200).make_withdrawl(500).display_user_balance()

Sarah.make_deposit(200).make_deposit(250).make_withdrawl(100).make_withdrawl(50).display_user_balance()

Josh.make_deposit(2000).make_withdrawl(150).make_withdrawl(150).make_withdrawl(150).display_user_balance()

Josh.make_transfer(505,Sarah)
print(Josh.account_balance)
print(Sarah.account_balance)



