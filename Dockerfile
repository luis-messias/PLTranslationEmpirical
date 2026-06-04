FROM ubuntu:22.04

ENV DEBIAN_FRONTEND=noninteractive

# System tools
RUN apt-get update && apt-get install -y \
        python3.10 \
        python3-pip \
        python3.10-dev \
        openjdk-11-jdk \
        maven \
        gcc \
        g++ \
        golang-go \
        curl \
    && rm -rf /var/lib/apt/lists/*

# Make python3 point to 3.10
RUN update-alternatives --install /usr/bin/python3 python3 /usr/bin/python3.10 1

WORKDIR /workspace

# Python dependencies (Ollama stack)
COPY requirements-ollama.txt .
RUN pip3 install --no-cache-dir -r requirements-ollama.txt seaborn matplotlib

# Project source
COPY src/       src/
COPY scripts/   scripts/
COPY prompts/   prompts/
COPY *.py       ./
COPY *.txt      ./

# Ensure scripts are executable
RUN chmod +x scripts/*.sh

# Ollama runs on the host (or a sidecar container).
# On Linux: pass --add-host=host.docker.internal:host-gateway to docker run,
# or use --network=host and set OLLAMA_HOST=http://localhost:11434.
ENV OLLAMA_HOST=http://host.docker.internal:11434

# dataset/, output/, fix_reports/ are mounted as volumes at runtime — not baked in.
VOLUME ["/workspace/dataset", "/workspace/output", "/workspace/fix_reports"]

CMD ["bash"]
