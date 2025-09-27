import os, sys, tempfile, subprocess
from typing import Dict, Any
from problem import PROBLEM

def _limit_resources_unix():
    """Batasi CPU & memori (Unix). Abaikan di Windows."""
    if os.name != "posix":
        return
    try:
        import resource
        # Batas CPU
        t = PROBLEM["time_limit_sec"]
        resource.setrlimit(resource.RLIMIT_CPU, (t, t))
        # Batas memori
        mem = PROBLEM["memory_limit_mb"] * 1024 * 1024
        resource.setrlimit(resource.RLIMIT_AS, (mem, mem))
    except Exception:
        pass

def run_python(code: str) -> Dict[str, Any]:
    with tempfile.TemporaryDirectory() as td:
        pyfile = os.path.join(td, "main.py")
        with open(pyfile, "w", encoding="utf-8") as f:
            f.write(code)
        try:
            p = subprocess.run(
                [sys.executable, pyfile],
                stdout=subprocess.PIPE,
                stderr=subprocess.PIPE,
                text=True,
                timeout=PROBLEM["time_limit_sec"],
                preexec_fn=_limit_resources_unix if os.name == "posix" else None,
            )
            return {"ok": True, "stdout": p.stdout, "stderr": p.stderr, "returncode": p.returncode}
        except subprocess.TimeoutExpired as e:
            return {"ok": False, "timeout": True, "stdout": e.stdout or "", "stderr": e.stderr or ""}
        except Exception as e:
            return {"ok": False, "error": str(e), "stdout": "", "stderr": ""}

def run_cpp(code: str) -> Dict[str, Any]:
    with tempfile.TemporaryDirectory() as td:
        src = os.path.join(td, "main.cpp")
        out = os.path.join(td, "a.out" if os.name != "nt" else "main.exe")
        with open(src, "w", encoding="utf-8") as f:
            f.write(code)

        # Compile
        try:
            c = subprocess.run(
                ["g++", "-std=c++17", "-O2", src, "-o", out],
                stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True
            )
        except FileNotFoundError:
            return {"ok": False, "compile_failed": True, "compile_output": "g++ tidak ditemukan di PATH."}

        if c.returncode != 0:
            return {"ok": False, "compile_failed": True, "compile_output": c.stderr}

        # Run
        try:
            p = subprocess.run(
                [out],
                stdout=subprocess.PIPE,
                stderr=subprocess.PIPE,
                text=True,
                timeout=PROBLEM["time_limit_sec"],
                preexec_fn=_limit_resources_unix if os.name == "posix" else None,
            )
            return {"ok": True, "stdout": p.stdout, "stderr": p.stderr, "returncode": p.returncode}
        except subprocess.TimeoutExpired as e:
            return {"ok": False, "timeout": True, "stdout": e.stdout or "", "stderr": e.stderr or ""}
        except Exception as e:
            return {"ok": False, "error": str(e), "stdout": "", "stderr": ""}

def judge(lang: str, code: str) -> Dict[str, Any]:
    exp = PROBLEM["expected_stdout"]
    if lang == "python":
        r = run_python(code)
    elif lang == "cpp":
        r = run_cpp(code)
    else:
        return {"status": "Runtime Error", "stdout": "", "stderr": "Bahasa tidak didukung."}

    if not r.get("ok"):
        if r.get("timeout"):
            return {"status": "Time Limit Exceeded", "stdout": r.get("stdout", ""), "stderr": r.get("stderr", "")}
        if r.get("compile_failed"):
            return {"status": "Compilation Error", "compile_output": r.get("compile_output", "")}
        return {"status": "Runtime Error", "stdout": r.get("stdout", ""), "stderr": r.get("error", r.get("stderr",""))}

    out = (r.get("stdout") or "").strip()
    status = "Accepted" if out == exp else "Wrong Answer"
    return {
        "status": status,
        "stdout": r.get("stdout", ""),
        "stderr": r.get("stderr", ""),
    }
