from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker, declarative_base
from sqlalchemy import Column, Integer, String

engine = create_engine("mysql+pymysql://root:sqlpass@localhost:3306/mydb2", echo=True)
Base = declarative_base()

Session = sessionmaker(bind=engine)
session = Session()

class Customer(Base):
    __tablename__ = "customer"
    id = Column(Integer, primary_key=True)
    name = Column(String(50))
    address = Column(String(100))
    email = Column(String(100))

Base.metadata.create_all(engine)

c1 = Customer(name = "Vu", address = "whateveraddress", email = "whatever@gmail.com")
session.add(c1)
session.commit()

# using query -- .all() returns a list
customers = session.query(Customer).all()
for customer in customers:
    print(c1.id, c1.name, c1.address, c1.email)

# updating object
x=session.get(Customer, 1)
x.address = "Fort Worth"
session.commit()

# applying filter
result = session.query(Customer).filter(Customer.id == 1)
for row in result:
    print ("ID:", row.id, "Name: ",row.name, "Address:",row.address, "Email:",row.email)

# filter + and operator
result = session.query(Customer).filter(Customer.id>2, Customer.name.like('V%'))
for row in result:
    print ("ID:", row.id, "Name: ",row.name, "Address:",row.address, "Email:",row.email)
