from flask_wtf import FlaskForm
from wtforms.validators import DataRequired, Length, EqualTo
from wtforms import StringField, PasswordField, SubmitField

class ResetForm(FlaskForm):
    username = StringField("username", validators=[DataRequired(), Length(min=3)])
    new_password = PasswordField("password", validators=[
        DataRequired(), 
        EqualTo("retype_password", message="Password must match.")])
    retype_password = PasswordField("re-type password", validators=[DataRequired()])
    submit = SubmitField("reset")