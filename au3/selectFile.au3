Local $flag
For $i = 5 To 1 Step -1
   WinActivate ( "��" )
   $flag = WinActive ( "��" )
   If $flag <> 0 Then ExitLoop
   Sleep(2000)
Next
Sleep(2000)
ControlSend("��", "", "Edit1", $CmdLine[1])
;ControlSend("��", "", "Edit1", "F:\picture\dd5.png")
Local $value =  ControlGetText("��", "", "Edit1")
ConsoleWrite ( $value )
For $j = 5 To 1 Step -1
   If $value == $CmdLine[1] Then ExitLoop
   ;If $value == "F:\picture\dd5.png" Then ExitLoop
   Send("{CTRLDOWN}")
   Send("a")
   Send("{CTRLUP}")
   Sleep(1000)
   ControlSend("��", "", "Edit1", $CmdLine[1])
   ;ControlSend("��", "", "Edit1", "F:\picture\dd5.png")
   Sleep(1000)
   $value =  ControlGetText("��", "", "Edit1")
Next

Sleep(1000)
ControlClick("��", "", "Button1")


