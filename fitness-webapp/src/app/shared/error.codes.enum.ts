const errorMessages = {
  /* eslint-disable @typescript-eslint/naming-convention */
  EC_0001:'Contact request already submitted from this mail.',
  EC_0002:'Contact request already submitted from this mobile number.',
  
  /* eslint-enable @typescript-eslint/naming-convention */
};
export type ErrorCode = keyof typeof errorMessages;

export function getMessage(key: ErrorCode): string {
  return errorMessages[key];
}
