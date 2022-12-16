$file_users=Import-Csv -Path trabajadores.csv
foreach ($user in $file_users) {
  $clave=ConvertTo-secureString $user.Password -AsPlainText -Force
  New-LocalUser $user.Cuenta -Password $clave -FullName $user.Nombre -Description $user.Descripcion -AccountNeverExpires $false -PasswordNeverExpires $false
  net user $user.Cuenta /logonpasswordchg:yes
  $grupos-usuario = ("usuarios",$user.Departamentos)
  foreach ($grupo in $grupos-usuario){
    Add-LocalGroupMember -Group $grupo -Member $user.Cuenta
  }
}
