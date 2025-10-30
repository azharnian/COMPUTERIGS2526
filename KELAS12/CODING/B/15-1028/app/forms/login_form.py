from flask_wtf import FlaskForm
from wtforms.validators import DataRequired, Length
from wtforms import StringField, PasswordField, SubmitField

class LoginForm(FlaskForm):
    username = StringField("username", validators=[DataRequired(), Length(min=3)])
    password = PasswordField("password", validators=[DataRequired()])
    submit = SubmitField("login")