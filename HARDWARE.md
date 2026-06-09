# Hardware Specifications

Machine used to run the translation / repair benchmarks (Ollama-based local inference).

## System

| Component | Specification |
|-----------|---------------|
| **OS**     | Ubuntu 24.04.4 LTS (Noble Numbat) |
| **Kernel** | 6.17.0-35-generic |
| **CPU**    | 12th Gen Intel Core i5-12600K — 10 cores / 16 threads, 0.8–4.9 GHz |
| **RAM**    | 31 GiB DDR + 92 GiB swap |
| **GPU**    | NVIDIA GeForce RTX 3060, 12 GB GDDR6 (driver 580.159.03, 170 W power limit) |
| **Disk**   | 824 GB NVMe SSD (`/dev/nvme0n1p1`) |

## Notes for reproduction

- **GPU memory (12 GB)** is the binding constraint for local inference. It comfortably runs
  sub-10B models through Ollama (e.g. `qwen3.5:9b` ≈ 6.6 GB, `gemma4:e4b` ≈ 9.6 GB) but is
  **not** large enough for models such as Mixtral-8x7B (~26 GB+ quantized).
- A CodeT5+ 220M-scale corrector fits trivially (<2 GB VRAM).
- The i5-12600K (16 threads) handles Maven/`javac`/`python` compile-and-test validation in
  parallel with model inference.
- All timings reported in the project assume **single-GPU, sequential** generation.

## Models run on this machine (Ollama)

| Model (tag) | Size on disk |
|-------------|-------------|
| `llama3.1:8b`     | 4.9 GB |
| `phi4-mini:3.8b`  | 2.5 GB |
| `gemma4:e2b`      | 7.2 GB | 
| `gemma4:e4b`      | 9.6 GB | 
| `qwen3.5:9b`      | 6.6 GB |

_Generation times estimated from output-file modification times (see `estimate_runtime.py`)._
