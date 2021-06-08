const successMessages = {
  /* eslint-disable @typescript-eslint/naming-convention */
  MSG_0001: 'Request Submitted, Trainer will contact you shortly.',
   /* eslint-enable @typescript-eslint/naming-convention */
};

export type SuccessCode = keyof typeof successMessages;

export function getMessage(key: SuccessCode): string {
  return successMessages[key];
}

export function getSuccessMessage(key: SuccessCode, message: string): string {
  // eslint-disable-next-line no-prototype-builtins
  if (successMessages.hasOwnProperty(key)) {
    return successMessages[key];
  } else if (message === '') {
    console.error(
      'Success message code is undefined in response, return default success message.',
    );
    return 'success';
  }
  return message;
}
