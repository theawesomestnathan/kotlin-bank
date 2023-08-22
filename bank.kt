// Account Class
class Account(username: String, password: String, money: Double) {

  // Variables
  var username: String = ""
    private set

  var password: String = ""
    private set
  
  private var money: Double = 0.0
    private set

  // Getters and Setters

  fun value_of_username(): String {
    return this.username
  }
  
  fun change_username(new_username: String) {
    this.username = new_username
  }

  fun value_of_password(): String {
    return this.password
  }
  
  fun change_password(new_password: String) {
    this.password = new_password
  }

  fun amount_of_money(): Double {
    return this.money
  }

  fun change_money(amount: Double) {
    this.money = amount
  }

  
  // Methods

  fun deposit(amount: Double) {
    change_money(amount_of_money() + amount)
  }

  fun withdraw(amount: Double) {
    if ((amount_of_money() - amount) <= 0) {
      return
    }
    change_money(amount_of_money() - amount)
  }

  // Initialization

  init {
    change_username(username)
    change_password(password)
    change_money(money)
  }

}

// Main function
fun main() {
  var accounts = mutableMapOf<String, String>()

  println("Welcome to Credit-Where-Credit-Isn't-Due Bank! Please login or register to continue.")
  println("[1] Login")
  println("[2] Register")

  var option: Int = 0

  do {
    try {
      option = Integer.parseInt(readLine()!!)
    }
    catch (e: NumberFormatException) {
      // Pass
    }
  }
  while (option > 2 || option < 1)

  var username: String = ""
  var password: String = ""

  do {
    if (option == 1) {
      println("Enter your username: ")
      username = readLine()!!

      println("Enter your password: ")
      password = readLine()!!
    }
    else if (option == 2) {
      println("Enter your username: ")
      var chosen_username: String = readLine()!!

      println("Enter your password: ")
      var chosen_password: String = readLine()!!

      accounts.put(chosen_username, chosen_password)

      option = 1
    }
  }
  while (!(accounts.containsKey(username)) && !(accounts[username] == password))

  var account: Account = Account(username, password, 100.0)

  println("Would you like to make a deposit or a withdraw?")
  
  do {
    try {
      var option = Integer.parseInt(readLine()!!)
    }
    catch (e: NumberFormatException) {
      // Pass
    }
  }
  while (option > 2 || option < 1)

  var amount_to_deposit: Double = 0.0
  var amount_to_withdraw: Double = 0.0

  while (true) {
    if (option == 1) {
      println("How much would you like to deposit?")
      try {
        amount_to_deposit = readLine()!!.toDouble()

        account.deposit(amount_to_deposit)

        break;
      }
      catch (e: NumberFormatException) {
        // Pass
      }
    }
    else if (option == 2) {
      println("How much would you like to withdraw?")
      try {
        amount_to_withdraw = readLine()!!.toDouble()

        account.deposit(amount_to_withdraw)

        break;
      }
      catch (e: NumberFormatException) {
        // Pass
      }
    }
  }
}