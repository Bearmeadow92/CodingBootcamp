from flask import Flask, render_template, redirect, request, session

app = Flask(__name__)
app.secret_key = "kiskis"


@app.route('/')
def yolo():
    return render_template("index.html")



@app.route('/result', methods=["POST"])
def yee():
    print(request.form)
    session["name"] = request.form["name"]
    session["locations"] = request.form["locations"]
    session["languages"] = request.form["languages"]
    session["comment"] = request.form["comment"]
    return redirect('/result')


@app.route("/result")
def end():
    return render_template("/results.html")

if __name__=="__main__":

    app.run(debug=True) 