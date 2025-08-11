from triangle_formula\
    import  type_triangle

import  pytest
from example_formula import (
    calculate_root,
    calculate_divide
)

def test_triangle_one():
    assert type_triangle(1, 2, 3)\
           == "Segitiga sembarang"

def test_triangle_two():
    assert type_triangle(1, 1, 4)\
            == "Segitiga sama kaki"

def test_triangle_three():
    assert type_triangle(4, 4, 4)\
        == "Segitiga sama sisi"


def test_root_one():
    with pytest.raises(ValueError):
        calculate_root(-10)

def test_root_two():
    assert  calculate_root(4) == 2.0

def test_divide():
    with pytest.raises(ZeroDivisionError):
        calculate_divide(10, 0)
