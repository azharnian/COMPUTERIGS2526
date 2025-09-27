import shutil
import sys
import pytest
from judge import judge

HAS_GPP = shutil.which("g++") is not None

def test_python_accepted():
    code = 'print("Hello, World!")\n'
    r = judge("python", code)
    assert r["status"] == "Accepted"
    assert r["stdout"].strip() == "Hello, World!"

def test_python_wrong_answer():
    code = 'print("hello, world!")\n'
    r = judge("python", code)
    assert r["status"] == "Wrong Answer"

def test_python_runtime_error():
    code = 'print(1/0)\n'
    r = judge("python", code)
    assert r["status"] == "Runtime Error"
    # boleh ada pesan ZeroDivisionError di stderr

def test_python_time_limit_exceeded():
    # Loop tanpa akhir; tetap kena timeout karena subprocess timeout
    code = 'while True:\n    pass\n'
    r = judge("python", code)
    assert r["status"] == "Time Limit Exceeded"

@pytest.mark.skipif(not HAS_GPP, reason="g++ not found")
def test_cpp_accepted():
    code = r'''
#include <bits/stdc++.h>
using namespace std;
int main(){ cout << "Hello, World!" << endl; }
'''
    r = judge("cpp", code)
    assert r["status"] == "Accepted"
    assert r["stdout"].strip() == "Hello, World!"

@pytest.mark.skipif(not HAS_GPP, reason="g++ not found")
def test_cpp_wrong_answer():
    code = r'''
#include <bits/stdc++.h>
using namespace std;
int main(){ cout << "HELLO, WORLD!" << endl; }
'''
    r = judge("cpp", code)
    assert r["status"] == "Wrong Answer"

@pytest.mark.skipif(not HAS_GPP, reason="g++ not found")
def test_cpp_compilation_error():
    code = r'''
#include <bits/stdc++.h>
using namespace std;
int main(  // sintaks salah: tidak ditutup
{ cout << "Hello, World!" << endl; }
'''
    r = judge("cpp", code)
    assert r["status"] == "Compilation Error"
    assert "error" in (r.get("compile_output") or "").lower()

@pytest.mark.skipif(not HAS_GPP, reason="g++ not found")
def test_cpp_time_limit_exceeded():
    code = r'''
#include <bits/stdc++.h>
using namespace std;
int main(){ while(true){} }
'''
    r = judge("cpp", code)
    assert r["status"] == "Time Limit Exceeded"
