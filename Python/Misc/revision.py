import os
from functools import partial
from tkinter import filedialog as fd
from random import choice, choices, sample
from configparser import ConfigParser as cfgp
from itertools import permutations, combinations_with_replacement


def file_dialogs() -> None:
    """Returns the path of the selected file from the file dialog window."""
    path: str = fd.askopenfilename(
        initialdir=os.getcwd(),
        title="File Dialog",
        filetypes=(("Text", "*.txt"), ("Config", "*.cfg")),
    )
    print(path)


def making_choices(s: str, k: int) -> None:
    samples: list[str] = [x for x in s.strip()]

    ch: str = choice(samples)
    chs: list[str] = choices(samples, k=k)
    chs_no_reps: list[str] = sample(samples, k=k)

    print(ch)
    print(chs)
    print(chs_no_reps)


def pnc(sample: str) -> None:
    sample_list: list[str] = [x for x in sample.strip()]

    perms = permutations(sample_list)
    combos_no_reps = combinations_with_replacement(sample_list, 2)

    print(f"All possible permutations for the sample {sample} are -")
    for perm in perms:
        for p in perm:
            print(p, end=" ")
        print()

    print(f"\nAll possible combinations for the sample : {sample} are -")
    for combo in combos_no_reps:
        for c in combo:
            print(c, end=" ")
        print()


def greet(name: str, greeting: str, emote: str = "🙃") -> None:
    message: str = f"{greeting}, {name}! {emote}"
    print(message)


def partial_intro(name: str = "Nirmit") -> None:
    welcome = partial(greet, greeting="Welcome", emote="🤗")
    goodbye = partial(greet, greeting="Bye", emote="😭")

    welcome(name=name)
    goodbye(name=name)


def exec_intro(filepath: str = "test.txt") -> None:
    data: list = []
    script: str = ""

    with open(filepath, "r") as file:
        data = file.readlines()

    if len(data):
        for line in data:
            script += line

    exec(script)


def read_config(configpath: str = "settings.cfg", section: str = "CONFIG") -> None:
    creds: dict[str, str] = {}

    config: cfgp = cfgp()
    config.read(configpath)
    config_section = config[section]

    for key in config_section:
        creds.update({key: config_section[key]})

    for key, value in creds.items():
        print(f"{key} : {value}")


def get_filepath() -> str:
    txt_path: str = ""

    for dirname, _, filenames in os.walk(os.getcwd()):
        for filename in filenames:
            if filename.endswith(".txt"):
                txt_path = os.path.join(dirname, filename)

    return txt_path


if __name__ == "__main__":
    # txt_path: str = get_filepath()

    # read_config(configpath="settings.cfg", section="CONFIG")

    # exec_intro(filepath=txt_path)

    # partial_intro(name="Nirmit")

    # pnc(sample="ABC")

    # making_choices(s="ABCD", k=2)

    file_dialogs()
