<!--publish=false-->
## 1.9.0:
- `26.1`: Update to <ins>26.1</ins>
- `1.20.1`, `1.21(.1)`: Add support for <ins>Every Compat</ins> (&#x200A;<sub><a title="Every Compat&#10;on Modrinth" href="https://modrinth.com/mod/every-compat/"><img width=20 src="https://img.shields.io/badge/-%20-%23032a?style=flat&logo=modrinth"></a></sub><!--SEPARATOR_V:MR--><img width=5 height=8 src="https://raw.githubusercontent.com/pnk2u/resources/main/ModProjects/shared/pres/icon/separator_v.svg"><sub><a title="Every Compat&#10;on Curseforge" href="https://www.curseforge.com/minecraft/mc-mods/every-compat/"><img width=20 src="https://img.shields.io/badge/--%23302a?style=flat&logo=curseforge"></a></sub>&#x200A;)
- Internal Changes:
    - `1.21(.1)+`: Update Mod ID from `lolmblv` to `more_barrel_variants` for clarity
      > This does not affect existing saves negatively, as the mod will still recognize the old ID and migrate it to the new one seamlessly.  
        While `1.20.1` retains the old ID due to the Fabric feature allowing for this kind of change only being available in `1.21(.1)+` versions,  
        upgrading to `1.21(.1)+` will still trigger the ID migration, making sure that you will continue to be able to update existing worlds safely to a newer Minecraft version.
    - Update main _Block_ and _Item Tag_ for consistency:  
      Now both Blocks and Items use `#more_barrel_variants:barrels` (`1.21(.1)+`) / `#lolmblv:barrels` (`1.20.1`)

<br></br>
<sub>License update to [CC-BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/) (previously [MIT](https://opensource.org/licenses/MIT))</sub>