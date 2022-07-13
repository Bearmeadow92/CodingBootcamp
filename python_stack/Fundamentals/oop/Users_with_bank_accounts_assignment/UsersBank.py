
class BankAccount:

        def __init__(self, int_rate = .10, balance = 0):
            self.int_rate = int_rate
            self.balance = balance


        def deposit(self, amount):
            self.balance += amount
            return self

        def withdrawl(self, amount):
            self.balance -= amount
            if self.balance <=0:
                self.balance -=5
                print(f"Insufficient funds: {self.balance} Charging a $5 fee")
            return self

        def display_account_info(self):
            print("Account balance:",self.balance)
            return self

        def yield_interest(self):
            self.balance += (self.balance*self.int_rate)
            return self

class User:
    def __init__(self,name,age):
        self.name = name
        self.age = age
        self.account = BankAccount()

    def display_user(self):
        print(f"User {self.name} Account Balance:{self.account.balance}")
        return self

    def make_deposit(self,amount):
        self.account.deposit(amount)
        return self

    def make_withdrawl(self,amount):
        self.account.withdrawl(amount)
        return self
    
    def make_transfer(self,amount,other_user):
        self.account -= amount
        other_user.account += amount
        return self


Jeff = User("Jeff", 34)
Ashley = User("Ashley",23)


Jeff.make_deposit(10).make_deposit(10).make_deposit(10).make_withdrawl(10).display_user()
Ashley.make_deposit(5).make_deposit(10).make_withdrawl(20).make_withdrawl(40).display_user()
