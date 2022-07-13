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



Jeff = BankAccount()
Ashley = BankAccount()


Jeff.deposit(10).deposit(10).deposit(10).withdrawl(10).yield_interest().display_account_info()
Ashley.deposit(5).deposit(10).withdrawl(20).withdrawl(40).yield_interest().display_account_info()

