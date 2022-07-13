from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import flash, re


DATABASE = 'recipes'

class Recipe:
    def __init__( self , data ):
        self.id = data['id']
        self.name = data['name']
        self.description = data['description']
        self.instructions = data['instructions']
        self.under_30_minutes = data['under_30_minutes']
        self.made_at = data['made_at']
        self.user_id = data['user_id']


    @classmethod
    def save(cls, data:dict) -> int:
        query = "INSERT INTO recipes (name, description, instructions, under_30_minutes, user_id, made_at) VALUES (%(name)s,%(description)s,%(instructions)s,%(under_30_minutes)s,%(user_id)s,%(made_at)s);"
        return connectToMySQL(DATABASE).query_db(query,data)

    @classmethod
    def update(cls, data):
        query = 'UPDATE recipes SET name=%(name)s, description=%(description)s,instructions=%(instructions)s,under_30_minutes=%(under_30_minutes)s,user_id=%(user_id)s,made_at=%(made_at)s WHERE id=%(id)s;'
        return connectToMySQL(DATABASE).query_db(query,data)

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM recipes;"
        results = connectToMySQL(DATABASE).query_db(query)
        print(results)
        recipes = []
        for recipe in results:
            recipes.append( cls(recipe) )
        return recipes

    @classmethod
    def get_one(cls,data):
        query  = "SELECT * FROM recipes WHERE id = %(id)s;"
        result = connectToMySQL('recipes').query_db(query,data)
        return cls(result[0])

    @classmethod 
    def destroy(cls,data):
        query  = "DELETE FROM recipes WHERE id = %(id)s;"
        return connectToMySQL('recipes').query_db(query,data)


    @staticmethod
    def validate_recipe(recipe:dict) -> bool:
        is_valid = True # ! we assume this is true
        if len(recipe['name']) < 3:
            flash("name must be at least 3 characters.")
            is_valid = False
        if len(recipe['description']) < 3:
            flash("description must be at least 3 characters.")
            is_valid = False
        if len(recipe['instructions']) < 3:
            flash("Instructions name must be at least 3 characters.")
            is_valid = False
        if recipe['made_at'] == "":
            flash("date cannot be blank.")
            is_valid = False
        return is_valid
