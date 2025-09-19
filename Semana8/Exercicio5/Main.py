import json
from Filme import Filme

def main():
    with open("filmes.json", "r", encoding="utf-8") as f:
        data = json.load(f)

    filmes = [Filme.from_json(item) for item in data]

    filmes.sort(key=lambda f: f.nota, reverse=True)

    print("\nLista de filmes ordenados por nota:\n")
    for filme in filmes:
        print(filme)

if __name__ == "__main__":
    main()
