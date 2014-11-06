READ ME Version 2.0
Team C - Braxton Frederick, Andrew Vogler, Arron Reed, Adam Audycki, Dylan Hogue
SWEN 262-01
11/5/14

HTML Editor:
A text editor that allows creation and editing of HTML files.  Able to check the form of a file based on markup structure.  Edit multiple files simultaneously with tabs in a simple Java application. 

Requirements:
Runs with a .JAR executable file through a start.bat.

Run: 
Download rel2project.zip.
Unzip the zip file and open the folder.
To run the program, double left click on the start.bat file.

Functionality:
To open a new file, left click "File" in the menu bar and select "New" (or use the ctrl+n hotkey).
To save an open file, click "File" and select "Save" (or use ctrl+s).
To save a file in a new location, click "File" and select "Save As" (or ctrl+e), and provide a new filename (including file extension).
To close the current file, click the "x" on the file tab.
To close the program, click "File" and select "Exit" (or ctrl+q).
If there is unsaved work, a prompt appears informing you.
To proceed, select yes (to continue without saving) or no (to cancel closing the tab).

To toggle off the WordWrap functionality (default: on), click on "Edit" in the menu bar, and click "Word Wrap" (or use ctrl+w). Select again to toggle back on.

To insert an HTML tag, select one of the HTML construct buttons above the buffer. For the three lists, a prompt appears asking how many list elements to create. For the table, a prompt appears asking for row and column amounts.

Folder Structure:
rel2project - main folder
source - contains the source code
documents - contains design, presentation, listing, vclog, and buildlog
start.bat - runs the program with necessary settings
r2editor.jar - runnable jar of the program

Commit History:
After accepting the invite to the project repo you can access the commit history page located here: https://bitbucket.org/262teamc/editor-2/commits/branch/master
It is also available in the documents folder under the name commit_log.txt.

Extra Functionality:
Reduced Functionality when not well formed.
Command-line argument to open file with the program.
