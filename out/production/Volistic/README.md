# 🎉・VOLISTIC・🎊

![Volistic Banner](https://github.com/PD-06/Volgion/assets/147963726/2f5450eb-fa90-4a58-9f76-e2911f7f7ce9)

Version: 1.2.1

**Volistic** is an **open-source** Java project, bundling the programs made by PD\`06 in IB Computer Science into one launcher program. Any student can create their own Java CLI program and include it on `Volistic.java` (The program launcher). The steps and procedures to do so are articulated on the '[CONTRIBUTING.md](https://github.com/PD-06/Volistic/blob/main/CONTRIBUTING.md)' file.

## Prerequisites

### - Have '[Git](https://git-scm.com/downloads)' installed (Click on the link to go to Git download page)

### - Download Java Development Kit (JDK)

1. Click [here](https://www.oracle.com/java/technologies/downloads/) to download JDK! (For MacOs: `ARM64 DMG Installer`)
2. Once done, open (run/execute) the JDK installer! (It's probably on your user's `Downloads` folder)
3. Follow through the installation process!

#### Installation Verification

1. Open up your desired terminal application! Default are:
       - 'Terminal' for MacOs & Linux!
       - 'Command Prompt' for Windows!
2. Type `java --version` to verify it!
3. If it's installed, it should be like this:
![Java-verified](https://github.com/DeffreusTheda/ComSci/assets/147963726/752f5d49-01cf-4f87-be2a-33838d471b06)

## 🍎・Wanna Try it Out??

1. On your machine, [clone this repository](https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository) into a your preferred folder!
2. Navigate to the cloned repository, and [open a terminal at the folder](https://www.google.com/search?client=opera-gx&q=opening+a+terminal+at+a+folder&sourceid=opera&ie=UTF-8&oe=UTF-8) `Volistic`!
3. Type `pwd` to your terminal and press `return↵`! If it show `.../Volistic` then your current working directory is correct!
4. Copy paste this command: `javac CLI/*.java; java CLI.Volistic` to your terminal and press `return↵`!
5. 🎉・It should now run the Volistic Program, have fun!・🎊

## 🎁・How to Get Started Contributing and Making Your Own Program on Volistic

You're highly suggested to use Pull Request to get your changes to the repository instead of direct edit. Please refer to `CODE_OF_CONDUCT.md` for follow-up on this guide here. If you need any help regarding this matter, kindly consult to: deffreus (Discord)

### Through Apache NetBeans

Refer to this documentation [here](https://netbeans.apache.org/tutorial/main/kb/docs/ide/git/).

### Through VSCode

1. Donwload & Install VSCode! See the guide [here](https://www.youtube.com/watch?v=U5swA1GRJ18)!
2. Open VSCode, then click the 'Extension' icon on the side bar!
3. Download the following extensions:

- GitHub Actions by GitHub
- GitHub Pull Requests and Issues by GitHub
- GitLens — Git supercharged (Optional; Highly recommended) by GitHub
- Markdown Preview Github Styling by Matt Bierner (Optional)
- Code Runner by Jun Han
- Code Time by Software (Optional)

- Java Language Support by George Fraser
- Java Run by caolin
- Debugger for Java by Microsoft
- Extension Pack for Java by Microsoft
- Language Support for Java(TM) by Red Hat

#### Link your GitHub Account

1. On the side bar, press the 'Accounts' icon, then press the sign in button!
2. You'll then be redirected to GitHub. Login to your account or create an account if you don't have one!
3. Follow through the instructions given!

#### Cloning the Repository

To work and make changes to the source code, it's recommended to edit in your own local repository than directly on the remote repository through GitHub website. Thus, you need to **clone** the remote repository, making a copy of it locally on your machine.

1. Press `Cmd⌘ + Shift⇧ + P` and type 'Git: Clone'!
2. Choose 'Clone from GitHub'!
3. Type 'PD-06/Volistic' and press `return↵`!
4. Select your preferred folder for the repository! (It's not recommended to put it on the 'Downloads' folder)
5. **Open the cloned repository!** You can now make changes to the code!
6. VSCode will ask if you trust the authors of the files. Check the 'Trust the authors of all files in the parent folder...' and click the 'Yes, I trust the authors' button!
7. Done! You can now edit the files on your local repository!

Tips: if the Java Language Support server crashed, press `Cmd⌘ + Shift⇧ + P` and type 'Java: Restart Java Language Server'!

#### Configuring Git

For pushing commits, git needs your GitHub account's username and email.

1. Open VSCode Terminal --> On the menu bar (top-most bar): Terminal > New Terminal
2. On the terminal, type `git config --global user.name "USERNAME"`, replacing USERNAME with your GitHub username!
3. Type `git config --global user.email "EMAIL"`, replacing EMAIL with your email, e.g `example@gmail.com`!

#### Remember to Frequently Pull

Whenever there's a change in the remote repository, you need to 'pull' that change to your local repository in order to stay up-to-date with remote changes. The 'Source Control' panel wil tell you if there's a change in the remote repository that you need to pull to your local repository.

1. Press `Cmd⌘ + Shift⇧ + P` and type 'Git: Pull', then press `return↵`!

#### Committing & Pushing Changes

When you're making code changes in VSCode, you're editing your local repository. To get your changes to the remote repository, you must 'commit' your changes and 'push' the commit. **Ideally, each commit is small and only discuss one topic of change; don't bundle multiple changes of different topics into one commit!**

1. Go to the 'Source Control' panel from the sidebar!
2. After you saved all your changes, under the 'Changes' dropdown, press `+` beside the **M**odified file that you want to commit!
3. After your changes are staged, under the 'SOURCE CONTROL' dropdown, enter a commit message describing what changes you made!
4. Press `Cmd⌘ + return↵` to send the commit!
5. Finally, 'push' your commit(s) by pressing `Cmd⌘ + Shift⇧ + P` and typing 'Git: Push'

## Support and Help

We mainly use Discord for this project. Go to the '# support-and-help' under the '🎁・Volistic' category. You can join our server [here](https://discord.gg/SwycRcrXwC).

## 🪪・License

[MIT](https://choosealicense.com/licenses/mit/)
