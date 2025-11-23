from db import get_db, seed_users
from auth import login
from menu import employee_menu

def main():
    get_db()
    seed_users()
    user_id = login()
    if user_id:
        employee_menu(user_id)

if __name__ == '__main__':
    main()