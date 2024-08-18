import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class AddEvent {
    fun addEvent() {
        println("Event Added")
        println("Current Date : ${getCurrentTime()}")
        userDetails()
    }

    private fun userDetails() {
        val scanner = Scanner(System.`in`)  // Create a Scanner object to read input

        while (true) {
            println("Create Account")
            println("1. Create with email")
            println("2. Create with phone number")
            println("3. Continue with Google")
            println("4. Exit")

            print("Enter your choice: ")
            val choice: Int = scanner.nextInt()  // Read user input and assign it to _choice

            when (choice) {  // Use when for cleaner conditional handling
                1 -> {
                    println("Creating account with email...")
                    addUser()
                }

                2 -> {
                    println("Creating account with phone number...")
                }

                3 -> {
                    println("Continuing with Google...")
                }

                4 -> {
                    println("Exiting...")
                    break  // Exit the loop if the user chooses 4
                }

                else -> println("Invalid choice, please try again.")
            }
        }
    }

    private fun getCurrentTime(): String {
        val currentDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yy")
        val formattedDate = currentDateTime.format(formatter)

        return formattedDate
    }

    private fun addUser() {

        print("Enter Email Address : ")
        val email: String = readln()

        print("Enter a user Name : ")
        var username: String? = readlnOrNull()

        print("Enter a password : ")
        val password: String = readln()

        if (username != null) {
            username = email
            if (isValidEmail(email))
                println("Email : $email")
            if (password.length >= 8) {
                println("Password : $password")
            }else{
                println("Password length must be a 8 character")
            }
            if (username.isBlank())
                username = email

            println("User Name : $username")

        }

    }

    private fun isValidEmail(email: String): Boolean {
        // Define the regex pattern for a valid email address
        val emailRegex = "^[A-Za-z](.*)(@)(.+)(\\.)(.+)"
        return email.matches(emailRegex.toRegex())
    }
}