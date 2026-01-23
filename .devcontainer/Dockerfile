# ---------- BASE ----------
FROM mcr.microsoft.com/vscode/devcontainers/base:ubuntu-24.04

USER root

# ---------- SYSTEM UPDATE ----------
RUN apt-get update && apt-get upgrade -y

# ---------- PYTHON ----------
RUN apt-get install -y python3 python3-pip python3-venv

# ---------- NODEJS LTS ----------
RUN curl -fsSL https://deb.nodesource.com/setup_lts.x | bash - && \
    apt-get install -y nodejs

# ---------- GCC/G++ VERSION 14 ----------
RUN apt-get install -y gcc-14 g++-14 make build-essential && \
    update-alternatives --install /usr/bin/gcc gcc /usr/bin/gcc-14 200 && \
    update-alternatives --install /usr/bin/g++ g++ /usr/bin/g++-14 200

# ---------- GIT ----------
RUN apt-get install -y git

# Cleanup
RUN apt-get clean
