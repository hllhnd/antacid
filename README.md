# Antacid
Antacid is a WIP configuration-free anti-spyware and anti-anti-feature mod for Minecraft Java edition.

# Building
A Gradle wrapper is not provided in this repository for security reasons. Gradle 8.9 with Java 21 is the tested development environment.

# Current Features
- Disable telemetry on client startup and world join
	- The optional telemetry option is ignored, as all telemetry sending is neutered.
- Impersonate vanilla client through a custom brand packet
	- Antacid does not attempt to mitigate exploits which can detect mods.
- Completely disable Minecraft Realms connectivity
	- It sucks.
		- It really sucks. And you shouldn't be using it. Uninstall Antacid if you wish to play on Realms.

# Planned Features
- Completely wipe Realms GUI elements
- Minimize HTTP calls to Mojang services
- Integrate with [nonfree mods](https://github.com/CaffeineMC/sodium-fabric/issues/2400) to disable their donation spam
- Integrate with free mods which include anti-features such as auto-updaters.

# Licensing
Antacid is made available to you under the GNU Lesser General Public License version 3 or, at your option, any later version.

See [COPYING](COPYING) and [COPYING.LESSER](COPYING.LESSER) for more information.
