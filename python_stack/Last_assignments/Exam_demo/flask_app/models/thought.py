from flask_app.config.mysqlconnection import connectToMySQL

DATABASE = 'models_schema'

class Thought:
    def __init__( self , data ):
        self.id = data['id']
        self.content = data['content']
        self.likes = data['likes']
        self.user_id = data['user_id']
        self.first_name = data['first_name']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

#! CREATE
#! class method to add a thought to the DB 
    @classmethod
    def save(cls, data:dict ) -> int:
        query = "INSERT INTO thoughts (content, likes, user_id) VALUES ( %(content)s, %(likes)s, %(user_id)s);"
        result = connectToMySQL(DATABASE).query_db( query, data )
        # print(result)
        return result
        #! the return stmt returns the id as an int of the thought created

#! READ
    @classmethod
    def get_all(cls) -> list:
        query = "SELECT thoughts.*, users.first_name FROM thoughts LEFT JOIN users ON users.id = thoughts.user_id;"
        results = connectToMySQL(DATABASE).query_db(query)
        print(results)
        thoughts = []
        for thought in results: #! taking dicts from DB and making thought objects
            thoughts.append( cls(thought) )
        print(thoughts)
        return thoughts

#! READ
    @classmethod
    def get_one(cls, data:dict) -> object:
        query = 'SELECT * FROM thoughts WHERE id = %(id)s;'
        result = connectToMySQL(DATABASE).query_db(query, data)
        return cls(result[0])

#! UPDATE
    @classmethod
    def update(cls, data:dict) -> object:
        query = 'UPDATE thoughts SET content=%(content)s, likes=%(likes)s, user_id=%(user_id)s WHERE id = %(id)s;'
        return connectToMySQL(DATABASE).query_db(query, data)

#! UPDATE
    @classmethod
    def update_likes(cls, data:dict) -> object:
        query = 'UPDATE thoughts SET likes=%(likes)s WHERE id = %(id)s;'
        return connectToMySQL(DATABASE).query_db(query, data)

#! DELETE
    @classmethod
    def destroy(cls, data:dict) -> object:
        query = 'DELETE FROM thoughts WHERE id = %(id)s;'
        return connectToMySQL(DATABASE).query_db(query, data)

#! VALIDATION
    @staticmethod
    def validate_thought(thought:dict) -> bool:
        is_valid = True # ! we assume this is true
        if len(thought['content']) < 5:
            flash("Name must be at least 3 characters.")
            is_valid = False
        if len(thought['likes']) < 2:
            flash("Name must be at least 3 characters.")
            is_valid = False
        return is_valid