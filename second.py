import yagmail
from datetime import datetime

def send_email(subject, body, to_email, from_email, password, attachment_file_path):
    # Initialize the yagmail SMTP client
    yag = yagmail.SMTP(from_email, password)

    # Send the email
    yag.send(
        to=to_email,
        subject=subject,
        contents=body,
        attachments=attachment_file_path,
    )

    print("Email sent successfully.")

# Example usage
now = datetime.now()
current_date = now.strftime("%Y-%m-%d")
file_name = current_date + '.csv'
subject = f"Attendance Report for {file_name}"
body = f"Dear sir/madam,\n\nPlease find the attached attendance report.\n\nBest regards,\nYour Name"
to_email = ""
from_email = ""
password = ""
attachment_file_path = [file_name]

send_email(subject, body, to_email, from_email, password, attachment_file_path)