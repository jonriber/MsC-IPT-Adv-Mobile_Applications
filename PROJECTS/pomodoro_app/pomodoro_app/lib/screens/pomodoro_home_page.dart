import 'package:flutter/material.dart';
import 'package:getwidget/getwidget.dart';
import '../services/firestore_service.dart';
import '../models/task_model.dart';

class PomodoroHomePage extends StatefulWidget {
  const PomodoroHomePage({super.key});

  @override
  _PomodoroHomePageState createState() => _PomodoroHomePageState();
}

class _PomodoroHomePageState extends State<PomodoroHomePage> {
  final TaskService _taskService = TaskService();
  int _workDuration = 25; // Default to 25 minutes

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: GFAppBar(
        title: const Text('Pomodoro Timer'),
        centerTitle: true,
        backgroundColor: GFColors.DARK,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            GFCard(
              title: GFListTile(
                title: const Text('Work Session'),
                icon: Icon(Icons.timer, color: GFColors.PRIMARY),
              ),
              content: Column(
                children: [
                  Text('$_workDuration Minutes',
                      style: const TextStyle(
                          fontSize: 48, fontWeight: FontWeight.bold)),
                  GFRating(
                    onChanged: (value) {
                      setState(() {
                        _workDuration = (value * 10).round();
                      });
                    },
                    value: _workDuration / 10,
                    filledIcon: Icon(Icons.star, color: GFColors.WARNING),
                    defaultIcon: Icon(Icons.star_border, color: GFColors.LIGHT),
                  ),
                  GFButton(
                    onPressed: () {
                      // Add timer start logic here
                    },
                    text: "Start Pomodoro",
                    color: GFColors.SUCCESS,
                    shape: GFButtonShape.pills,
                  ),
                ],
              ),
            ),
            Expanded(
              child: StreamBuilder<List<Task>>(
                stream: _taskService.getTasks(),
                builder: (context, snapshot) {
                  if (snapshot.hasError) {
                    return Center(child: Text('Error: ${snapshot.error}'));
                  } else if (snapshot.hasData) {
                    final tasks = snapshot.data!;
                    return ListView.builder(
                      itemCount: tasks.length,
                      itemBuilder: (context, index) {
                        final task = tasks[index];
                        return GFListTile(
                          title: Text(task.title),
                          avatar: GFAvatar(
                            backgroundColor: task.isCompleted
                                ? GFColors.SUCCESS
                                : GFColors.WARNING,
                            child: Icon(
                              task.isCompleted
                                  ? Icons.check
                                  : Icons.pending,
                              color: GFColors.WHITE,
                            ),
                          ),
                          icon: GFCheckbox(
                            onChanged: (bool? value) {
                              setState(() {
                                task.isCompleted = value ?? false;
                                _taskService.updateTask(task);
                              });
                            },
                            value: task.isCompleted,
                            inactiveBgColor: GFColors.DANGER,
                          ),
                        );
                      },
                    );
                  } else {
                    return const Center(child: CircularProgressIndicator());
                  }
                },
              ),
            ),
          ],
        ),
      ),
      floatingActionButton: GFFloatingWidget(
        child: GFButton(
          onPressed: () {
            // Add task creation logic here
          },
          text: "New Task",
          icon: const Icon(Icons.add),
          color: GFColors.PRIMARY,
        ),
        verticalPosition: 0.9,
        horizontalPosition: 0.9,
      ),
    );
  }
}
