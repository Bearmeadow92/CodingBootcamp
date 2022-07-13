from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import flash, re


DATABASE = 'paintings_schema'

class Painting:
    def __init__( self , data ):
        self.id = data['id']
        self.name = data['name']
        self.description = data['description']
        self.price = data['price']
        self.user_id = data['user_id']


    @classmethod
    def save(cls, data:dict) -> int:
        query = "INSERT INTO paintings (name, description, price, user_id) VALUES (%(name)s,%(description)s,%(price)s,%(user_id)s);"
        return connectToMySQL(DATABASE).query_db(query,data)

    @classmethod
    def update(cls, data):
        query = "UPDATE paintings SET name=%(name)s, description=%(description)s,price=%(price)s,user_id=%(user_id)s WHERE paintings.id=%(id)s;"
        return connectToMySQL(DATABASE).query_db(query,data)

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM paintings;"
        results = connectToMySQL(DATABASE).query_db(query)
        print(results)
        paintings = []
        for painting in results:
            paintings.append( cls(painting) )
        return paintings

    @classmethod
    def get_one(cls,data):
        query  = "SELECT * FROM paintings WHERE id = %(id)s;"
        result = connectToMySQL('paintings_schema').query_db(query,data)
        return cls(result[0])

    @classmethod 
    def destroy(cls,data):
        query  = "DELETE FROM paintings WHERE id = %(id)s;"
        return connectToMySQL('paintings_schema').query_db(query,data)


    @staticmethod
    def validate_painting(painting:dict) -> bool:
        is_valid = True # ! we assume this is true
        if len(painting['name']) < 2:
            flash("Title must be at least 2 characters.")
            is_valid = False
        if len(painting['description']) < 10:
            flash("description must be at least 10 characters.")
            is_valid = False
        if len(painting['price']) < 1:
            flash("Price must be greater than $0.00.")
            is_valid = False
        return is_valid
