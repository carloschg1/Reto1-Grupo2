$file_groups=Import-Csv -Path departamentos.csv
foreach ($group in $file_groups) {
  New-LocalGroup -Name $group.Nombre -Description $group.Descripcion
}

$file_users=Import-Csv -Path trabajadores.csv
foreach ($user in $file_users) {
  $clave=ConvertTo-secureString $user.Password -AsPlainText -Force
  New-LocalUser $user.Password $clave -Description $user.Descripcion -AccountNeverExpires $false -PasswordNeverExpires $false
  net user $user.Password /logonpasswordchg:yes
  Add-LocalGroupMember -Group usuarios -Member $user.Password
  Add-LocalGroupMember -Group $user.Departamentos -Member $user.Password
}
