# udacity-courses

This android application uses the Udacity API to read the current list of Tracks and Courses. The information is displayed over three screen in which the user can drill down to see the relevant information associated with a particular course.

The main screen provides an overview of the Udacity tracks. Each track has an associated brief as well as the number of courses observed from the data returned via the API query. Tracks selected as a favourite will display a star (currently highlighted in green). Once the user selects a track, the screen activity will change to display a list of the courses available.

![Alt text](images/udacity_main_med.png?raw=true "Udacity Curated")

The courses screen lists each of the available courses for the track selected on the main screen. Here each course has brief information presented on the level and title for each specific course. The FAB provides a means to select/deselect a particular track as a favourite. The favourite is performed using SharedPreferences rather than database access - as it was felt a database would be overkill for such a simple action. Selection of a course will then display a new activity detailing the key information for a course.

![Alt text](images/track_detail_med.png?raw=true "List of courses")

The course detail activity displays the information for main items of interest e.g. expected learning, syllabus and instructors. Unfortunately the Udacity API, has some information missing dependant on the course, so there may be certain gaps in the information presented.

![Alt text](images/course_detail_med.png?raw=true "List of courses")

The next step for the application is to refactor the application architecture as it was cobbled together as a proof of concept. 

Libraries
<ol>Picasso</ol>
<ol>Stetho<ol/>

The current list of course materials taken from the API endpoint (https://www.udacity.com/public-api/v0/courses)

Udacity Degrees
# - 17

Udacity Courses
# - 159

Udacity Tracks
# - 7

