import mysql.connector

db_config = {
    "host": "localhost",
    "port": 3306,
    "user": "root",
    "password": "sqlpass",
    "database": "mydb2"
}

try:
    # Establish the connection
    mydb = mysql.connector.connect(**db_config)
    mycursor = mydb.cursor()

    # Execute a query
    mycursor.execute("INSERT INTO contact_list ( name, email, phone_number) Values (%s,%s,%s)",
                     ("Bao", "bao@gmail.com", 5099923424))
    mycursor.execute("SELECT * FROM contact_list")

    # Fetch and print the results
    for row in mycursor:
        print(row)

except mysql.connector.Error as err:
    print(f"Error: {err}")

finally:
    # Close the cursor and connection
    if 'mycursor' in locals() and mycursor is not None:
        mycursor.close()
    if 'mydb' in locals() and mydb.is_connected():
        mydb.close()
        print("Connection closed.")
