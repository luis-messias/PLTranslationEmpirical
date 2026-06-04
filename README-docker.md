# Docker Setup

## Build

```bash
docker build -t pltranslation .
```

Image size: ~563 MB 

## Run

**Linux** — Ollama runs on the host; `--add-host` makes it reachable inside the container:

```bash
docker run -it \
  --add-host=host.docker.internal:host-gateway \
  -v $(pwd)/dataset:/workspace/dataset \
  -v $(pwd)/output:/workspace/output \
  -v $(pwd)/fix_reports:/workspace/fix_reports \
  pltranslation \
  python3 run_benchmarks.py --run
```

## Requirements

- [Ollama](https://ollama.com) must be running on the host at port `11434` before starting the container.
- The `dataset/` directory must be present on the host (download from [Zenodo](https://zenodo.org/doi/10.5281/zenodo.8190051) and unzip).

## What is and isn't in the image

| Included | Mounted at runtime |
|----------|--------------------|
| `src/`, `scripts/`, `prompts/` | `dataset/` |
| `run_benchmarks.py`, `plot_results.py` | `output/` |
| All Python / Java / system dependencies | `fix_reports/` |

`output/` and `fix_reports/` are mounted so results persist after the container exits.

## Changing the Ollama host

If Ollama is running somewhere other than the host machine:

```bash
docker run -it -e OLLAMA_HOST=http://<ip>:11434 ... pltranslation
```
